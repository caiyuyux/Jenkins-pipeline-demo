#!/usr/bin/env groovy

def call() {
  echo "Hello ${animal}."

  pipeline {
    agent any

    stages {
            stage('test ansible') {
                  parameters {
                      string(name: 'ANSIBLE_HOME', defaultValue: '/var/pipeline-library/ansible')
                    }
                steps {
                      // 切换到 ansible 主目录
                      sh 'cd ${params.ANSIBLE_HOME}'
                  
                      sh 'ansible-playbook ${params.ANSIBLE_HOME}/tasks/main.yml -i ${params.ANSIBLE_HOME}/hosts -e "project_name=some value"'
                    }             
                }
            }
      }
 }
