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
		if($scope.curso.codigo === ""){
			$http.post(url,$scope.curso).success(function(curso) {
				$scope.curso.push(curso);
				$scope.novo();
			}).error(function(mensagemErro){
				alert(mensagemErro);
			});
		}
		else{
			$http.put(url,$scope.curso).success(function() {
				$scope.pesquisar();
				$scope.novo();
			}).error(function(mensagemErro){
				alert(mensagemErro);
			});
		}
	}
	
	$scope.excluir = function(){
		if($scope.curso.codigo === ""){
			alert("Selecione alguma categoria");
		}
		else{
			urlAux = url + "/" + $scope.curso.codigo;
			$http.delete(urlAux).success(function() {
				$scope.pesquisar();
				$scope.novo();
			}).error(function(mensagemErro) {
				alert(mensagemErro);
			});
		}
	}
	
	$scope.pesquisar();
});