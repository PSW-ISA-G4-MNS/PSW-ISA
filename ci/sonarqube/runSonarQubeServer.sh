#!/bin/sh

docker run --rm \
  --name psw.isa.sonarqube \
  -p 444:9000 \
  --hostname psw.isa.sonarqube \
  -v sonarqube_conf:/opt/sonarqube/conf \
  -v sonarqube_extensions:/opt/sonarqube/extensions \
  -v sonarqube_logs:/opt/sonarqube/logs \
  -v sonarqube_data:/opt/sonarqube/data \
  sonarqube