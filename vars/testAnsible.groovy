#!/usr/bin/env groovy

def call() {
  echo "Hello ${animal}."

  pipeline {
    agent any

    stages {
            stage('test ansible') {
                steps {

                	withEnv(["PATH+ANSIBLE=${tool '2.4.1.0'}"]) {

                   	ansiblePlaybook(
                      inventory: '/var/pipeline-library/ansible/hosts',
                      playbook: '/var/pipeline-library/ansible/tasks/main.yml',
                      extras: '-e project_name="some value"')  
                    }             
                }
            }
      }
 }}
