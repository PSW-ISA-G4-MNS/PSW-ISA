#!/bin/sh

docker run -it -v /var/run/docker.sock:/var/run/docker.sock \
     -p 443:8080 -p 445:50000 \
     -v jenkins_home:/var/jenkins_home \
     -v $(which docker):/usr/bin/docker -p 8080:8080 --name psw_isa_CI myjenk