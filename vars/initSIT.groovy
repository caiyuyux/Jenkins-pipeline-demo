#!/usr/bin/env groovy

def projects = ["java_base", "java_api"]
def parallelStagesMap = projects.collectEntries {
  ["${it}" : generateStage(it)]
}

def generateStage(project) {
  return {
    stage("stage: ${project}") {
      sh script: "sleep 15"
    }
  }
}


def call() {

  pipeline {
    agent any

    tools {
      maven 'apache-maven-3.0.1' 
    }

    stages {

      // echo "准备开始初始化 SIT. 初始化动物:${animal}."

      stage('Checkout') {

        steps {

          echo '初始化新分支: ${branch}'
          script {
            parallel parallelStagesMap
          }
        }             

      }

      // stage('InitTapd') {

      //   // echo '修改 Tapd '
      //   // 爬虫

      // }

      // stage('Ansible') {

      // }

      stage('构建项目') {

        // env.PATH = "${mvnHome}/bin:${env.PATH}"


        // 并行

        steps {

          sh 'pwd'
          ansiblePlaybook( 
            playbook: "/var/pipeline-library/ansible/tasks/main.yml",
            inventory: "/var/pipeline-library/ansible/hosts", 
            extraVars: [
              host: "${animal}",
              project: "${project}"
            ])
        }
      }
    }

    post { 
      always { 
        echo 'I will always say Hello again!'
      }
    }
  }
}
