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
		if($scope.modalidade.codigo == undefined){
			$http.post(urlModalidade,$scope.modalidade).success(function(modalidade) {
				$scope.modalidades.push($scope.modalidade);
				$scope.novo();
				alert("Cadastro realizado com sucesso .");
			}).error(function(mensagemErro){
				alert(mensagemErro);
			});
		}
		else{
			$http.put(urlModalidade,$scope.modalidade).success(function() {
				$scope.pesquisarModalidade();
				$scope.novo();
				alert("Atualizacao realizada com sucesso .");
			}).error(function(mensagemErro){
				alert(mensagemErro);
			});
		}
	}
	
	$scope.excluir = function(){
		if($scope.modalidade.codigo == undefined){
			alert("Selecione alguma modalidade");
		}
		else{
			urlAux = urlModalidade + "/" + $scope.modalidade.codigo;
			$http.delete(urlAux).success(function() {
				$scope.pesquisarModalidade();
				$scope.novo();
				alert("Exclusao realizada com sucesso .");
			}).error(function(mensagemErro) {
				alert(mensagemErro);
			});
		}
	}
	
	$scope.pesquisarModalidade();
	$scope.pesquisarCurso();
});