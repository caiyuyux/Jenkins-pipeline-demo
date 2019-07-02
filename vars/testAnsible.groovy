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
                      // sh "export ANSIBLE_CONFIG=${params.ANSIBLE_HOME}"
                  
                      ansiblePlaybook( 
                          playbook: "/var/pipeline-library/ansible/tasks/main.yml",
                          inventory: "/var/pipeline-library/ansible/hosts", 
                          extras: '-e parameter="some value"')
                    }             
                }
            }
      }
 }
