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
                   sh 'ansible-playbook /var/pipeline-library/ansible/tasks/main.yml -i /var/pipeline-library/ansible/hosts -e "parameter=some value"'         

                  ansiblePlaybook( 
                          playbook: "${params.ANSIBLE_HOME}/tasks/main.yml",
                          inventory: "${params.ANSIBLE_HOME}/hosts", 
                          extras: '-e parameter="some value"')
                }
            }
    }}
 }
