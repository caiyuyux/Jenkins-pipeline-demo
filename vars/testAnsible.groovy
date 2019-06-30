#!/usr/bin/env groovy

def call() {
  echo "Hello ${animal}."

  pipeline {
    agent any

    stages {
            stage('构建镜像') {
                steps {
                    sh "echo ttt"
                    sh "yum install wget"
                    sh "wget -O build.sh https://git.x-vipay.com/docker/jenkins-pipeline-library/raw/master/resources/shell/build.sh"
                }
            }
  }
  }}
