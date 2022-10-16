
JENKINS_NODE_COOKIE=dontKillMe
echo "  =====关闭Java应用======"
PROCESS=`ps -ef |grep java |grep -v grep|grep xxx.jar|awk '{print $2}'`
for i in $PROCESS
do
  echo "Kill the $1 process [ $i ]"
  kill -9 $i
done
echo "  =====启动Java应用======"
nohup java -jar /var/lib/jenkins/workspace/h3-price/target/dockerfile-demo-0.0.1-SNAPSHOT.jar >/home/logs/h3-price.info.log 2>&1 &
echo $! > savePid.txt
cat savePid.txt
rm  savePid.txt