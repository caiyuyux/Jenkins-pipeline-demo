#!/usr/bin/env groovy

def call() {
  echo "Hello ${animal}."

  pipeline {
    agent any

    stages {
            stage('test ansible') {
                steps {

                	withEnv(["PATH+ANSIBLE=${tool 'ansible'}"]) {

                   	ansiblePlaybook(
                      inventory: '/var/pipeline-library/ansible/hosts',
                      playbook: '/var/pipeline-library/ansible/tasks/main.yml',
                      extras: '-e project_name="some value"')  
                    }             
                }
            }
      }
 }}
