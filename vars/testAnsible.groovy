#!/usr/bin/env groovy

def call() {
  echo "Hello ${animal}."

  pipeline {
    agent any

    stages {
        stage('test') {
		steps {
		     ansiblePlaybook(
		        inventory: '/var/pipeline-library/ansible/hosts',
		        playbook: '/var/pipeline-library/ansible/tasks/main.yml',
			    extras: '-e project_name="some value"')}
		}
    }
  }
}
