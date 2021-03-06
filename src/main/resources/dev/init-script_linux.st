#!/bin/sh

APP_USER=$user$
APP_NAME=$applicationName$
APP_BASE_DIR=$targetSystemApplicationLocation$
APP_VERSION=$applicationVersion$
COMMONS_DAEMON_JAR_LOCATION=$targetSystemDaemonJarLocation$
COMMONS_DAEMON_JAR_NAME=$daemonJarName$
COMMONS_DAEMON_JAR_FULL_PATH=\$COMMONS_DAEMON_JAR_LOCATION/\$COMMONS_DAEMON_JAR_NAME
STARTUP_DELAY=$delay$

JAVA_HOME=$targetSystemJavaHome$
DAEMON=/usr/bin/jsvc

TMP_DIR=/tmp
PID_FILE=/var/run/jsvc-\$APP_NAME.pid

CLASSPATH=\$COMMONS_DAEMON_JAR_FULL_PATH:\$APP_BASE_DIR/\$APP_NAME-\$APP_VERSION-jar-with-dependencies.jar

start() {
    echo "Starting \$APP_NAME as a daemon..."

    \$DAEMON \
    -pidfile \$PID_FILE \
    -procname \$APP_NAME \
    -user \$APP_USER \
    -home \$JAVA_HOME \
    -Djava.io.tmpdir=\$TMP_DIR \
    -Djava.awt.headless=true \
    -outfile /var/log/\$APP_NAME \
    -errfile '&1' \
    -wait \$STARTUP_DELAY \
    -cp \$CLASSPATH \
    $mainClass$ $applicationArguments$
    # To get a verbose JVM
    #-verbose \
    # To get a debug of jsvc.
    #-debug \
}

stop() {
    echo "Stopping \$APP_NAME..."

    \$DAEMON \
    -stop \
    -pidfile \$PID_FILE \
    $mainClass$
}

status() {
    local PID="null"
    if [ -s \$PID_FILE ]; then
        PID=\$(cat \$PID_FILE)
    fi

    if [ -d /proc/\$PID ]; then
        echo "- \$APP_NAME is running [\$PID]"
    else
        echo "- \$APP_NAME is NOT running"
    fi
}


case "\$1" in
    start)
        start
        ;;
    stop)
        stop
        ;;
    restart)
        stop
        start
        ;;
    status)
        status
        ;;
    *)
        echo "Usage: \$0  { start | stop | restart | status }"
        exit 1
esac

exit 0
