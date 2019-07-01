#!/usr/bin/env groovy

def call() {
  echo "Hello ${animal}."

  pipeline {
    agent any

    stages {
            stage('test ansible') {
                steps {
                   	  sh 'ansible-playbook /var/pipeline-library/ansible/tasks/main.yml -i /var/pipeline-library/ansible/hosts -e "project_name=some value"'
                    }             
                }
            }
      }
 }
