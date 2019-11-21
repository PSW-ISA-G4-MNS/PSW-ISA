#!/bin/sh

FRONTEND_DIR="$(readlink -f "$1")"

docker run -it --rm \
	--name PSW_ISA_frontend \
	--link PSW_ISA_backend \
	--volume "$FRONTEND_DIR/dist":/usr/share/nginx/html/dist \
	--volume "$FRONTEND_DIR/index.html":/usr/share/nginx/html/index.html \
	--publish 9001:80 \
	nginx
