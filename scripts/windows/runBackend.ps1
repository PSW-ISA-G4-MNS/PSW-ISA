
[CmdletBinding()]
param (
    [Parameter()]
    [atring]
    $BackendPath
)

$BACKEND_DIR = Resolve-Path -Path $BackendPath
$SOURCE_DIR="$BACKEND_DIR/src/main/java"
$RESOURCES_DIR="$BACKEND_DIR/src/main/resources"
$TEST_DIR="$BACKEND_DIR/src/test"
docker run --hostname backend.psw --link PSW_ISA_postgres -it --rm --name PSW_ISA_backend -v "$BACKEND_DIR/pom.xml":/usr/src/mymaven/pom.xml -v "$SOURCE_DIR":/usr/src/mymaven/src/main/java -v "$TEST_DIR":/usr/src/mymaven/src/test -v "$RESOURCES_DIR/application-docker.properties":/usr/src/mymaven/src/main/resources/application.properties -w /usr/src/mymaven --publish 9000:8080 maven mvn spring-boot:run
