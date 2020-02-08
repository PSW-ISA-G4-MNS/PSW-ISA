
while true; do

    curl 127.0.0.1:300/service/scheduleOperation -X POST 
    curl 127.0.0.1:300/service/scheduleCare -X POST 
    sleep 24h
done

