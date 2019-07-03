#!/usr/bin/env groovy

def call() {
  echo "Hello ${animal}."

  pipeline {
    agent any

    stages {
            stage('test ansible') {

                steps {
                  
                  sh 'pwd'
                  ansiblePlaybook( 
                          playbook: "/var/pipeline-library/ansible/tasks/main.yml",
                          inventory: "/var/pipeline-library/ansible/hosts", 
                          extraVars: [
                              host: "${animal}",
                              project: "test"
                    ])
                }
            }
    }}
 }
