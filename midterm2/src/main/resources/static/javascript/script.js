$(document).ready(function(){
  //Creamos el filtro
  $('.categoria_item').click(function(){
    var categoriaProd = $(this).attr('category');
    console.log(categoriaProd);
    
      //Ocultamos los proyectos
  $('.proyectos_item').css('transform', 'scale(0)');
  function ocultarProd(){
    $('.proyectos_item').hide();
  } setTimeout(ocultarProd, 400);
  
  //Mostramos los productos por categoria
  function mostrarProd(){
    $('.proyectos_item[category="'+categoriaProd+'"]').fadeIn();
    $('.proyectos_item[category="'+categoriaProd+'"]').css('transform', 'scale(1)');
  } setTimeout(mostrarProd, 400);
  });
  
  //Mostrar todos los productos
  $('.categoria_item[category="all"]').click(function(){
    function verTodo(){
      $('.proyectos_item').fadeIn();
      $('.proyectos_item').css('transform', 'scale(1)');
    } setTimeout(verTodo, 400);
  });
});

