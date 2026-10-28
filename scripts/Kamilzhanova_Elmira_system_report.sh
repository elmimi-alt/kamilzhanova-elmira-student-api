#!/bin/bash

NAME="Kamilzhanova Elmira"

{
    echo "Name: $NAME"

    echo "Date and time:"
    date

    echo "Username:"
    whoami

    echo "Operating system:"
    cat /etc/os-release

    echo "Kernel:"
    uname -r

    echo "CPU:"
    lscpu

    echo "Memory:"
    free -h

    echo "Disk usage and available space:"
    df -h

} | tee logs/Kamilzhanova_Elmira_system_report.log
