var cartApp = angular.module('cartApp', []);

cartApp.controller("cartCtrl", function($scope, $http) {

	$scope.initCartId = function(cartId) {
		$scope.cartId = cartId;
		$scope.refreshCart();
	};

	$scope.refreshCart = function() {
		$http.get('/eStore/api/cart/' + $scope.cartId).then(
				function successCallback(response) {
					$scope.cart = response.data;
				});
	};

	$scope.clearCart = function() {

		$scope.setCsrfToken();

		$http({
			method : 'DELETE',
			url : '/eStore/api/cart/' + $scope.cartId
		}).then(function successCallback() {
			$scope.refreshCart();
		}, function errorCallback(response) {
			console.log(response.data);
		});
	};

	$scope.addToCart = function(productId) {

		$scope.setCsrfToken();

		$http.put('/eStore/api/cart/add/' + productId).then(
				function successCallback() {
					alert("Product successfully added to the cart!");
				}, function errorCallback() {
					alert("Adding to the cart failed!");
				});
	};

	$scope.removeFromCart = function(productId) {

		$scope.setCsrfToken();

		$http({
			method : 'DELETE',
			url : '/eStore/api/cart/cartitem/' + productId
		}).then(function successCallback() {
			$scope.refreshCart();
		}, function errorCallback(response) {
			console.log(response.data);
		});
	};

	$scope.calGrandTotal = function(){
		var grandTotal = 0;
		
		for(var i=0; i< $scope.cart.cartItems.length; i++){
			grandTotal += $scope.cart.cartItems[i].totalPrice;
		}
		
		return grandTotal;
	};
	
	//quantity를 1 증가시키는 메서드
	$scope.plusQuantity = function(productId) {
		$scope.setCsrfToken();
		// /eStore/api/cart/plusQuantity/ url을 http put메서드로 Dispatcher servlet에게 request한다
		$http({
			method : 'PUT',
			url : '/eStore/api/cart/plusQuantity/' + productId
		}).then(function successCallback() {
			$scope.refreshCart(); //성공시 response의 내용을 가져와서 refresh한다.
		}, function errorCallback(response) {
			console.log(response.data);
			alert("재고량이 부족합니다");
		});
	};
	//quantity를 1 감소시키는 메서드
	$scope.minusQuantity = function(productId) {
		$scope.setCsrfToken();
		// /eStore/api/cart/minusQuantity/ url을 http put메서드로 Dispatcher servlet에게 request한다
		$http({
			method : 'PUT',
			url : '/eStore/api/cart/minusQuantity/' + productId
		}).then(function successCallback() {
			$scope.refreshCart(); //성공시 response의 내용을 가져와서 refresh한다.
		}, function errorCallback(response) {
			console.log(response.data); //실패시 response의 내용 콘솔에 출력
			alert("더이상 제거할 수 없습니다");
		});
	};

	$scope.setCsrfToken = function() {
		var csrfToken = $("meta[name='_csrf']").attr("content");
		var csrfHeader = $("meta[name='_csrf_header']").attr("content");

		$http.defaults.headers.common[csrfHeader] = csrfToken;
	}

});