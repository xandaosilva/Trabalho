var categoriaModule = angular.module("categoriaModule",[]);

categoriaModule.controller("categoriaController", function($scope,$http) {
	urlCategoria = "http://localhost:8080/Trabalho/rs/categoria";
	urlModalidade = "http://localhost:8080/Trabalho/rs/modalidade";
	
	$scope.novo = function(){
		$scope.categoria = "";
	}

	$scope.selecionaCategoria = function(categoria){
		$scope.categoria = categoria;
	}
	
	$scope.pesquisarCategoria = function(){
		$http.get(urlCategoria).success(function(categorias) {
			$scope.categorias = categorias;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});
	}
	
	$scope.pesquisarModalidade = function(){
		$http.get(urlModalidade).success(function(modalidades) {
			$scope.modalidades = modalidades;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});
	}
	
	$scope.salvar = function(){
		if($scope.categoria.codigo == undefined){
			$http.post(urlCategoria,$scope.categoria).success(function(categoria) {
				$scope.categorias.push($scope.categoria);
				$scope.novo();
				alert("Cadastro realizado com sucesso .");
			}).error(function(mensagemErro){
				alert(mensagemErro);
			});
		}
		else{
			$http.put(urlCategoria,$scope.categoria).success(function() {
				$scope.pesquisarCategoria();
				$scope.novo();
				alert("Alteracao realizada com sucesso .");
			}).error(function(mensagemErro){
				alert(mensagemErro);
			});
		}
	}
	
	$scope.excluir = function(){
		if($scope.categoria.codigo == undefined){
			alert("Selecione alguma categoria");
		}
		else{
			urlAux = urlCategoria + "/" + $scope.categoria.codigo;
			$http.delete(urlAux).success(function() {
				$scope.pesquisarCategoria();
				$scope.novo();
				alert("Exclusao realizada com sucesso .");
			}).error(function(mensagemErro) {
				alert(mensagemErro);
			});
		}
	}
	
	$scope.pesquisarCategoria();
	$scope.pesquisarModalidade();
});