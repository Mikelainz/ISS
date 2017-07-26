#!/usr/bin/python           	# This is SysKb.py file

class SysKb(object) :
	host = "localhost"
	port = 8037
	delay = 20		# delay between steps in millisecs
	delta = 360.0 / 128.0  
	steps = 80 / delta 		# 512 is a full rotation = 
	maxAngle = steps * delta * 2
	
	delayValue = int(delay) / 1000.0
	rgbdelayValue = 0.2
	
	intruderDistance = 20
	limitDistance = 254
	
#print "delta="+str( SysKb.delta )