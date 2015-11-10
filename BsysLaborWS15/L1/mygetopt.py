#! /usr/bin/env python3

import argparse
import helper

parser = argparse.ArgumentParser()
parser.add_argument("-v","--version",action="store_true",
                    help="Ausgabe des GIT Token des Commits ")
#parser.add_argument("-h","--help",action="store_true",
 #                   help="Hilfe zu mÃ¶glichen Parametern ")
parser.add_argument("-o","--output",action="store_true",
                    help="gibt statt auf Konsole in die Datei mit Namen FILENAME au ")
parser.add_argument("-p","--python",action="store_true",
                    help=" Python Environment ")
parser.add_argument("-s","--system",action="store_true",
                    help="System Info ")
parser.add_argument("-c","--cpu",action="store_true",
                    help="CPU Infos")
parser.add_argument("-m","--memory",action="store_true",
                    help="Summieren  ")
args = parser.parse_args()

if args.python:
	helper.print_python_info()
elif args.system:
	helper.print_system_info()
elif args.cpu:
	helper.print_cpu_info()

