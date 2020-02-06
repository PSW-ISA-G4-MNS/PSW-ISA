#!/bin/sh

docker run -it -v /var/run/docker.sock:/var/run/docker.sock \
     -v $(which docker):/usr/bin/docker -p 8080:8080 --name psw_isa_CI myjenk