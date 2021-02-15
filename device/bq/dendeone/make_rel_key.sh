#!/bin/bash
# make directory for release key
mkdir security
# jump to root of source
cd ../../..
# add cert info
subject='/C=DE/ST=Berlin/L=Berlin/O=Andie_Klampfe,Inc./OU=Andie_Klampfe Mobility/CN=Andie_Klampfe/emailAddress=andi_schmidt@posteo.de'
# generate all cert and keys, 
# on password promt, press enter (empty/none password)
# put key and cert to security folder
for x in releasekey platform shared media networkstack testkey verity verity_key; do \
./development/tools/make_key ./device/bq/dendeone/security/$x "$subject"; \
done
cd ./device/bq/dendeone/
