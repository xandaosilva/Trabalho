var cursoModule = angular.module("cursoModule",[]);

cursoModule.controller("cursoController", function($scope,$http) {
	url = "http://localhost:8080/Trabalho/rs/curso";
	
	$scope.novo = function(){
		$scope.curso = "";
	}
	
	$scope.seleciona = function(curso){
		$scope.curso = curso;
	}
	
	$scope.pesquisar = function(){
		$http.get(url).success(function(cursos) {
			$scope.cursos = cursos;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});
	}
	
	$scope.salvar = function(){
		if($scope.curso.codigo == undefined){
			$http.post(url,$scope.curso).success(function(curso) {
				$scope.cursos.push($scope.curso);
				$scope.novo();
				alert("Cadastro realizado com sucesso .");
			}).error(function(mensagemErro){
				alert(mensagemErro);
			});
		}
		else{
			$http.put(url,$scope.curso).success(function() {
				$scope.pesquisar();
				$scope.novo();
				alert("Alteracao realizada com sucesso .");
			}).error(function(mensagemErro){
				alert(mensagemErro);
			});
		}
	}
	
	$scope.excluir = function(){
		if($scope.curso.codigo == undefined){
			alert("Selecione alguma categoria");
		}
		else{
			urlAux = url + "/" + $scope.curso.codigo;
			$http.delete(urlAux).success(function() {
				$scope.pesquisar();
				$scope.novo();
				alert("Exclusao realizada com sucesso .");
			}).error(function(mensagemErro) {
				alert(mensagemErro);
			});
		}
	}
	
	$scope.pesquisar();
});