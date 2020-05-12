import sys
import subprocess
import os
import shutil
import pathlib

data_path = 'IO/'
verbose = 'v' in sys.argv
if verbose:
	sys.argv.remove('v')


#get filenames for a problem
def get_data(prob_num):
	tc = 1
	data = []
	while True:
		file_in = '%sprob%02d-%d-in.txt' % (data_path, prob_num, tc)
		file_out = '%sprob%02d-%d-out.txt' % (data_path, prob_num, tc)
		if not os.path.isfile(file_in):
			break
		data += [(file_in, file_out)]
		tc += 1
	return data


#diffs output
def diff(first, second):
	for i in range(min(len(first),len(second))):
		if first[i] != second[i]:
			return (False,first[i],second[i],str(i+1))
	return (True,'','','')


#tests sol across all data
def test_solution(folder, sol, data):
	os.mkdir('.workspace')
	shutil.copy(folder+'/'+sol, '.workspace/')
	try:
		try:
			subprocess.check_call(["javac", '.workspace/'+sol], stderr=open(os.devnull, 'w'))
		except:
			return (False,['Compilation Error'])
		results = []
		ok = True
		os.chdir('.workspace')
		for (fin, fout) in data:
			shutil.copy(f'../{fin}', 'input.txt')
			try:
				sol_out = subprocess.check_output(["java", sol[:-5]], stderr=open(os.devnull, 'w'))
				samp_out = pathlib.Path(f'../{fout}').read_text()
				sol_out = sol_out.decode('utf-8').replace('\r', '').split('\n')
				samp = samp_out.split('\n')
				d = diff(sol_out,samp)
				if d[0]:
					results += ['OK']
				else:
					ok = False
					if verbose:
						results += [f'Wrong Answer\n      Your Output: {d[1]}\n      Sample Data: {d[2]}']
					else:
						results += [f'Wrong Answer (line {d[3]})']
			except:
				ok = False
				results += ['Runtime Error']
		os.chdir('..')
		return (ok, results)
	finally:
		shutil.rmtree('.workspace')

if len(sys.argv) >= 2 and os.path.isdir('./'+sys.argv[1]):
	folder = sys.argv[1]
	#test 1 problem
	if(len(sys.argv) >= 3 and sys.argv[2].isdigit()):
		prob_num = int(sys.argv[2])
		data = get_data(prob_num)
		if len(data) == 0: 
			print('Problem', prob_num, 'does not exist')
		else:
			sol = 'prob%02d.java' % prob_num
			if os.path.isfile(folder+'/'+sol):
				passed, results = test_solution(folder, sol, data)
				if passed:
					print('Accepted')
				else:
					print('Incorrect')
					for ind, res in enumerate(results):
						print('  Test Case ', ind+1, ': ', res, sep='')
			else:
				print('Not Attempted')
	#Test person
	else:
		prob_num = 0
		print('Checking',folder)
		data = get_data(prob_num)
		while len(data) != 0: 
			print('  Problem', prob_num, end=': ')
			sol = 'prob%02d.java' % prob_num
			if os.path.isfile(folder+'/'+sol):
				passed, results = test_solution(folder, sol, data)
				if passed:
					print('Accepted')
				else:
					print('Incorrect')
					for ind, res in enumerate(results):
						print('    Test Case ', ind+1, ': ', res, sep='')
			else:
				print('Not Attempted')
			prob_num += 1
			data = get_data(prob_num)
#test everything
else:
	folders = [f.path for f in os.scandir('.') if f.is_dir()]
	folders.remove('./IO')
	folders.remove('./.github')
	folders.remove('./.git')
	for folder in folders:
		prob_num = 0
		print('Checking',folder[2:])
		data = get_data(prob_num)
		while len(data) != 0: 
			print('  Problem', prob_num, end=': ')
			sol = 'prob%02d.java' % prob_num
			if os.path.isfile(folder+'/'+sol):
				passed, results = test_solution(folder, sol, data)
				if passed:
					print('Accepted')
				else:
					print('Incorrect')
					for ind, res in enumerate(results):
						print('    Test Case ', ind+1, ': ', res, sep='')
			else:
				print('Not Attempted')
			prob_num += 1
			data = get_data(prob_num)
