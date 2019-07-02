#!/usr/bin/env groovy

def call() {
  echo "Hello ${animal}."

  pipeline {
    agent any

    stages {
            stage('test ansible') {
              
              sh 'cd /var/pipeline-library/ansible'
                steps {
                   	  sh 'ansible-playbook tasks/main.yml -i hosts -e "project_name=some value"'
                    }             
                }
            }
      }
 }
