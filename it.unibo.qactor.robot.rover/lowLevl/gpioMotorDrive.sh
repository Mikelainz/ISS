#!/bin/bash
# -------------------------------------
# motorDrive.sh
# Key-point: we can manage a GPIO pin 
# by using the GPIO library.
# -------------------------------------

    
in1=15	#WPI 16 PHYSICAL 10
in2=18  #WPI 1  PHYSICAL 12

if [ -d /sys/class/gpio/gpio15 ] 
then 
	echo "in1 gpio${in1} exist"
	gpio export 15 out 
else 
	echo "creating in1 gpio${in1}"
	gpio export 15 out  
fi

if [ -d /sys/class/gpio/gpio18 ] 
then 
	echo "in2 gpio${in2} exist"
	gpio export 18 out 
else 
	echo "creating in2  gpio${in2}"
	gpio export 18 out  
fi

 
echo "run 1" 
	gpio write 16 0
	gpio write 1 1
	sleep 2.5 
echo "run 2" 
 	gpio write 16 1
	gpio write 1 0
 	sleep 1.5 
 echo "stop" 
	gpio write 16 0
	gpio write 1 0
 