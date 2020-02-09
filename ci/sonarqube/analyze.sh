#!/bin/sh


BACKEND_DIR="$(readlink -f $1)"
SOURCE_DIR="$BACKEND_DIR/src/main/java"
RESOURCES_DIR="$BACKEND_DIR/src/main/resources"
TEST_DIR="$BACKEND_DIR/src/test"

function run_docker() {
	docker run \
		--hostname backend.psw.analysis \
		--link psw.isa.sonarqube \
		--link PSW_ISA_postgres \
		-it --rm \
		--name PSW_ISA_backend_analysis \
		-v "$BACKEND_DIR/pom.xml":/usr/src/mymaven/pom.xml \
		-v "$SOURCE_DIR":/usr/src/mymaven/src/main/java \
		-v "$TEST_DIR":/usr/src/mymaven/src/test \
		-v "$RESOURCES_DIR/application-docker.properties":/usr/src/mymaven/src/main/resources/application.properties \
		-v "$BACKEND_DIR/.m2/":/root/.m2 \
		-w /usr/src/mymaven \
		maven mvn clean verify $1
}

run_docker sonar:sonar