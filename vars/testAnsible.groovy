#!/usr/bin/env groovy

def call() {
  echo "Hello ${animal}."

  pipeline {
    agent any
    parameters {
        string(name: 'ANSIBLE_HOME', defaultValue: '/var/pipeline-library/ansible')
    }

    stages {
            stage('test ansible') {

                steps {
                      // 设置环境变量
                      sh "export ANSIBLE_CONFIG=${params.ANSIBLE_HOME}"
                  
                      sh "ansible-playbook ${params.ANSIBLE_HOME}/tasks/main.yml -i ${params.ANSIBLE_HOME}/hosts -e 'project_name=some'"
                    }             
                }
            }
      }
 }
