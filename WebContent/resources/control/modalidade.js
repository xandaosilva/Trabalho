var modalidadeModule = angular.module("modalidadeModule",[]);

modalidadeModule.controller("modalidadeController", function($scope,$http) {
	urlModalidade = "http://localhost:8080/Trabalho/rs/modalidade";
	urlCurso = "http://localhost:8080/Trabalho/rs/curso";
	
	$scope.novo = function(){
		$scope.modalidade = "";
	}
	
	$scope.selecionaModalidade = function(modalidade){
		$scope.modalidade = modalidade;
	}
	
	$scope.pesquisarModalidade = function(){
		$http.get(urlModalidade).success(function(modalidades) {
			$scope.modalidades = modalidades;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});
	}
	
	$scope.pesquisarCurso = function(){
		$http.get(urlCurso).success(function(cursos) {
			$scope.cursos = cursos;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});
	}
	
	$scope.salvar = function(){
		if($scope.modalidade.codigo === ""){
			$http.post(urlModalidade,$scope.modalidade).success(function(modalidade) {
				$scope.modalidade.push(modalidade);
				$scope.novo();
			}).error(function(mensagemErro){
				alert(mensagemErro);
			});
		}
		else{
			$http.put(urlModalidade,$scope.modalidade).success(function() {
				$scope.pesquisarModalidade();
				$scope.novo();
			}).error(function(mensagemErro){
				alert(mensagemErro);
			});
		}
	}
	
	$scope.excluir = function(){
		if($scope.modalidade.codigo == ""){
			alert("Selecione alguma modalidade");
		}
		else{
			urlAux = urlModalidade + "/" + $scope.modalidade.codigo;
			$http.delete(urlAux).success(function() {
				$scope.pesquisarModalidade();
				$scope.novo();
			}).error(function(mensagemErro) {
				alert(mensagemErro);
			});
		}
	}
	
	$scope.pesquisarModalidade();
	$scope.pesquisarCurso();
});