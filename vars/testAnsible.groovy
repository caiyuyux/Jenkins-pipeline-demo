#!/usr/bin/env groovy

def call() {
  echo "Hello ${animal}."

  pipeline {
    agent any

    stages {
            stage('构建镜像') {
                steps {
                    sh "mkdir ttt"
                }
            }
  }
  }}
