
JENKINS_NODE_COOKIE=dontKillMe
echo "启动项目"
java -jar /var/lib/jenkins/workspace/h3-price/target/dockerfile-demo-0.0.1-SNAPSHOT.jar >/home/logs/h3-price.info.log 2>&1 &
echo "exec java-jar command!"