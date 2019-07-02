#!/usr/bin/env groovy

def call() {
  echo "Hello ${animal}."

  pipeline {
    agent any

    stages {
            stage('test ansible') {
              
                steps {
                      // 切换到 ansible 主目录
                      sh 'cd /var/pipeline-library/ansible'
                  
                      sh 'ansible-playbook tasks/main.yml -i hosts -e "project_name=some value"'
                    }             
                }
            }
      }
 }
