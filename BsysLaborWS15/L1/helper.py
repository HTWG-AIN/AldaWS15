#! /usr/bin/env python3

import platform
import sys
#import colorama
import os
import logging

def python_info():
	# Return: Python-Version-String (without space)
        # logging.info("Python Version")
        # logger.setLevel(logging.info)
    logging.basicConfig(level=logging.INFO)
    logger = logging.getLogger(__name__)
    logger.info('Python Version')
	
    return platform.python_version()
	
   # logger.info('Finish Infos about the Version')
def print_python_info():
    print(python_info())
    
def system_info():
	# Return: Dictionary with Systeminformation
    logging.basicConfig(level=logging.DEBUG)
    logger = logging.getLogger(__name__)
    logger.info('System Informations')
        #logger.setLevel(logging.debug)
        
        
   # dict = {"Architecture": str(platform.architecture()[0]),
#		"Kernel Release": str(platform.release()),
#		"System": str(platform.system()),
#		"Linux Release": str(platform.dist()[0]),
#		"Linux Distributen": str(platform.dist()[1])}


            #sys.platform.startswith('win')
    dict = {}
    dict["System"]= str(platform.system())
    
    #def win32_ver(release='', version='', csd='', ptype=''):
    if dict["System"] == 'Windows' :
            dict["release"], dict["version"],dict["csd"],dict["ptype"] = platform.win32_ver()
    
    # platform.mac_ver(release='', versioninfo=('', '', ''), machine='')
    #Get Mac OS version information and return it as tuple (release, versioninfo, machine)
    #with versioninfo being a tuple (version, dev_stage, non_release_version).
    #the core of Mac OS X is the Darwin OS.
    elif dict["System"] == 'Darwin' :
          dict["release"], dict["versioninfo"],dict["machine"]  = platform.mac_ver()
    else:
        #platform.system_alias(system, release, version)
        #Returns (system, release, version) aliased to common marketing names used for some systems. 
         dict["Architecture"] = str(platform.architecture()[0])
       #  dict["Alias"] = platform.system_alias(dict["System"], dict["release"], dict["version"])
         dict["Kernel Release"]= str(platform.release())
         dict["Linux Release"]= str(platform.dist()[0])
         dict["Linux Distributen"]= str(platform.dist()[1])
	
        
    return dict

        
def print_system_info():
	
	print ("{:<20} {:<20}".format("LABEL","CONTENT"))
	for k, v in system_info().items():
		print ("{:<20} {:<20}".format(k, v))
	
        
def codename(family,model):
	# Return String: Codename as String
	logger = logging.getLogger('model'+ str(model)+ 'family' + str(family))
	logger = logging.getLogger(__name__)
	logger.setLevel(logging.DEBUG)
	logger.info('Codename')
	#print("ddddddddddddddd")
	with open("proc_code.txt") as myfile:
		#print("aaaaaaaaa")
		lines = myfile.readlines()
		lines.pop(0) #removes first line
		
		for line in lines:
			columns = line.split(":")
			columns = [x.strip() for x in columns]
			#print(columns)
			#print("test")
			print("STRSTER",str(int(columns[2],16)))
			print("FAMILY",int(family))
			if int(columns[2],16) == family:
				if int(columns[3],16) == model:
					#print(columns[0])
					return columns[0]
			else:
				print("NIXXXX")
		return print("N")
		
					



		#print(content)
		#or row in content:
			#column =  # read without whitespace characters #convert from hex to int
			#family1 = column[2]#int(column[2])
			#print("FAMILY")
			#print(family1)
			#if family1 == family:
				#model1 = int(column[3],16)
				#if model1 == model:
					#return column[0]
			#return content[1]
    #close(myfile)        

#def print_codename(f,m):

	#print(codename(f,m))           

	
def cpu_info():
	# Return: Dictionary with Dictionary, Key of the first Dic ist the CPU Number	
        #logging.debug("CPU Informations")
		logging.basicConfig(level=logging.DEBUG)
		logger = logging.getLogger(__name__)
		logger.info('CPU Informations')

		
		#modelname = ''
		#frequency = ''
		#model= ''
		#family = ''
		#codename= ''
		#arch = ''
		with open('/proc/cpuinfo','r') as myfile:
			infos = myfile.readlines()
			processor = ''
			modelname = ''
			model = ''
			family = ''
			codename1 = ''
			arch = ''
			frequency = ''
			
			dict = {}
			for i in range(11):
				
			
				for line in infos:
					if line.strip():
						if  line.rstrip('\n').startswith('processor'):
							processor = line.rstrip('\n').split(':')[1]
						elif line.rstrip('\n').startswith('model name'):
							modelname = line.rstrip('\n').split(':')[1]
						elif line.rstrip('\n').startswith('cpu MHz'):
							frequency = line.rstrip('\n').split(':')[1]
						elif line.rstrip('\n').startswith('model'):
							model = line.rstrip('\n').split(':')[1]
							model = int(model)
						elif line.rstrip('\n').startswith('cpu family'):
							family = line.rstrip('\n').split(':')[1]
							family =int(family)
							codename1 = codename(family,model)
							#print("COOOO",codename(family,model))
							#print("ssssssssssssssssss",model)
							#print("ssssss",family)
						#elif line.rstrip('\n').startswith('codename'):
							#codename1 = codename(family,model)
							#print(codename1)
						elif line.rstrip('\n').startswith('flags'):
							if 'lm' in line.rstrip('\n').split():
								arch= '64-bit'
							else:
								arch= '32-bit'
						#elif family != '':
							#codename1 = codename(family,model)
						#print("ssssssss",family)
						#print(model)
				dict[i] = {"Processor: ": processor,"Modelname: ": modelname,"Architecture: ": arch ,"Frequency: ": frequency ,"Codename: ": codename1, "Model :" : model,"Family: " : family }
			
		return dict
        


#def tree():
	# print(helper.codename(model, family))	
def print_cpu_info():
    #print ("{:<20} {:<20}".format("LABEL","CONTENT"))
		
	for k, v in cpu_info().items():
		print("Prozessor #" + str(k))
		for kk, vv in v.items():
			#print(kk, vv)			
			print("{:<20} {:<20}".format(kk, vv))
	#print(print_codename(62,6))
	
	#print(cpu_info())
def quit():
	exit()
