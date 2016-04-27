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
		}).error(function(erro) {
			alert(erro);
		});
	}
	
	$scope.pesquisarModalidade = function(){
		$http.get(urlModalidade).success(function(modalidades) {
			$scope.modalidades = modalidades;
		}).error(function(erro) {
			alert(erro);
		});
	}
	
	$scope.salvar = function(){
		if($scope.categoria.codigo === ""){
			$http.post(urlCategoria,$scope.categoria).success(function(categoria) {
				$scope.categoria.push(categoria);
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}
		else{
			$http.put(urlCategoria,$scope.categoria).success(function() {
				$scope.pesquisarCategoria();
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}
	}
	
	$scope.excluir = function(){
		if($scope.categoria.codigo === ""){
			alert("Selecione alguma categoria");
		}
		else{
			urlAux = url + "/" + $scope.categoria.codigo;
			$http.delete(urlAux).success(function() {
				$scope.pesquisarCategoria();
				$scope.novo();
			}).error(function(mensagemErro) {
				alert(mensagemErro);
			});
		}
	}
	
	$scope.pesquisarCategoria();
	$scope.pesquisarModalidade();
});