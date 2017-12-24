#!/usr/bin/env python
#Packet breakdown and examples

#"[00000101]<-Add [000000000001] <-Storage location [00000101]  <- Add [000000000010] <-Storage location
#"[00000101]<-Add [001111101000] <-Storage location [00000110] <- Subtract [000001100100] <-Storage location
#"[00000101]<-Add [000000110010] <-Storage location [00001011] <- Multiply [000000001100] <-Storage location
#"[00000101]<-Add [000000110010] <-Storage location [00001100] <- Divide [000000000101] <-Storage location



ac=0 
r1=0
r2=0

ui=raw_input("Please enter IAS packet: ")


words=[ui]



def execute(opcode, address):
	global ac	
	execute.opcode=opcode
	execute.address=address
	if opcode=="00000101":
		ac+=int(address, 2)
	if opcode=="00000110":
		ac-=int(address, 2)
	if opcode=="00001011":
		ac=ac*int(address, 2)
	if opcode=="00001100":
		ac=ac/int(address, 2)




while r1<len(words[0]):	
	execute(words[0][r1: r1+8], words[0][r1+8:r1+20])
	r1+=20

print(ac)
