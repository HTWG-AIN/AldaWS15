#! /usr/bin/env python3
import helper
import sys
if __name__ == "__main__":
    print ("Menu")
    print ("1: Python Info")
    print ("2: System Info")
    print ("3: CPU Info")
    print ("q: Quit menu.py")
    print ("------------------------------------")
    print ("Waehle ['1','2','3','q']")

    while True:
            m =input("choose = ")
            try:
                if (m == "1"):
                    helper.print_python_info() 
                    continue
                elif (m == "2"):
                    helper.print_system_info()
                    continue
                elif (m == "3"):
                    helper.print_cpu_info()
                    continue
                elif (m == "q") :
                    print("Exit!")
                    helper.quit()
                else : 
                    print("Ungueltige Eingabe !")
            except ValueError:
                print("Bitte Waehle ['1','2','3','q']..... ")

             
       
   


#! /usr/bin/env python3
import helper
import sys
if __name__ == "__main__":
    print ("Menu")
    print ("1: Python Info")
    print ("2: System Info")
    print ("3: CPU Info")
    print ("q: Quit menu.py")
    print ("------------------------------------")
    print ("Waehle ['1','2','3','q']")

    while True:
            m =input("choose = ")
            try:
                if (m == "1"):
                    helper.print_python_info() 
                    continue
                elif (m == "2"):
                    helper.print_system_info()
                    continue
                elif (m == "3"):
                    helper.print_cpu_info()
                    continue
                elif (m == "q") :
                    print("Exit!")
                    helper.quit()
                else : 
                    print("Ungueltige Eingabe !")
            except ValueError:
                print("Bitte Waehle ['1','2','3','q']..... ")

             
       
   


