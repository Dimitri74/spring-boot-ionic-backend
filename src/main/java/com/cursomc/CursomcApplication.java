package com.cursomc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cursomc.services.S3Service;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	
	@Autowired
	private S3Service s3Service; 

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		s3Service.uploadFile("C:\\Users\\dell\\workspace\\temp\\bsb.jpg");
	}

}

/*
 * @Autowired private CategoriaRepositorio repo;
 * 
 * @Autowired private ProdutoRepositorio repoProd;
 * 
 * @Autowired private EstadoRepositorio estadoRepo;
 * 
 * @Autowired private CidadeRepositorio cidadeRepo;
 * 
 * @Autowired private EnderecoRepositorio enderecoRepositorio;
 * 
 * @Autowired private ClienteRepositorio clienteRepositorio;
 * 
 * @Autowired private PedidoRepositorio pedidoRepositorio;
 * 
 * @Autowired private PagamentoRepositorio pagamentoRepositorio;
 * 
 * @Autowired private ItemPedidoRepositorio itemPedidoRepositorio;
 * 
 * public static void main(String[] args) {
 * SpringApplication.run(CursomcApplication.class, args); }
 * 
 * public void run(String... args) throws Exception { Categoria cat1 = new
 * Categoria(null , "Informática"); Categoria cat2 = new Categoria(null ,
 * "Escriório"); Categoria cat3 = new Categoria(null , "Cama Mesa e Banho");
 * Categoria cat4 = new Categoria(null , "Elêtronicos"); Categoria cat5 = new
 * Categoria(null , "Decoração");
 * 
 * 
 * Produto p1 = new Produto(null , "Computador" , 2000.00); Produto p2 = new
 * Produto(null , "Impressora" , 800.00); Produto p3 = new Produto(null ,
 * "Mesa de escritorio" , 300.00); Produto p4 = new Produto(null , "Toalha" ,
 * 50.00); Produto p5 = new Produto(null , "Colcha" , 200.00); Produto p6 = new
 * Produto(null , "Tv true color" , 1200.00); Produto p7 = new Produto(null ,
 * "Roçadeira" , 800.00); Produto p8 = new Produto(null , "Abajour" , 100.00);
 * Produto p9 = new Produto(null , "Pendente" , 80.00); Produto p10 = new
 * Produto(null , "Mouse" , 80.00); Produto p11 = new Produto(null , "Shampoo" ,
 * 90.00);
 * 
 * cat1.getProdutos().addAll(Arrays.asList(p1 , p2, p3 ));
 * cat2.getProdutos().addAll(Arrays.asList(p2, p4));
 * cat3.getProdutos().addAll(Arrays.asList(p5, p6));
 * cat4.getProdutos().addAll(Arrays.asList(p1, p2 ,p3 ,p7));
 * cat5.getProdutos().addAll(Arrays.asList(p8, p9 , p10 , p11));
 * 
 * 
 * p1.getCategorias().addAll(Arrays.asList(cat1 ,cat4));
 * p2.getCategorias().addAll(Arrays.asList(cat1 , cat2 , cat4));
 * p3.getCategorias().addAll(Arrays.asList(cat1 , cat5));
 * 
 * 
 * repo.saveAll(Arrays.asList(cat1, cat2 , cat3 , cat4 , cat5));
 * repoProd.saveAll(Arrays.asList(p1 , p2, p3 ,p4,p5,p6,p7,p8,p9,p10,p11 ));
 * 
 * Estado est1 = new Estado(null , "Distrito Federal"); Estado est2 = new
 * Estado(null , "São Paulo");
 * 
 * Cidade c1 = new Cidade(null , "Brasília" , est1); Cidade c2 = new Cidade(null
 * , "São Paulo" , est2); Cidade c3 = new Cidade(null , "Campinas" , est2);
 * 
 * est1.getCidades().addAll(Arrays.asList(c1));
 * est2.getCidades().addAll(Arrays.asList(c2, c3));
 * 
 * estadoRepo.saveAll(Arrays.asList(est1 , est2));
 * cidadeRepo.saveAll(Arrays.asList(c1, c2,c3));
 * 
 * Cliente cli1 = new Cliente(null , "Maria Silva" , "maria@gmail" ,
 * "36378912377" , TipoCliente.PESSOAFISICA);
 * cli1.getTelefones().addAll(Arrays.asList("27363323" , "93838393"));
 * 
 * Endereco e1 = new Endereco(null, "Rua Manacá", "4", "Apto 1401",
 * "Aguas Claras", "71907270", cli1, c1); Endereco e2 = new Endereco(null,
 * "Avenida Matos", "105", "Sala 800", "Centro", "38220834", cli1, c2);
 * 
 * cli1.getEnderecos().addAll(Arrays.asList(e1 , e2));
 * 
 * clienteRepositorio.saveAll(Arrays.asList(cli1));
 * enderecoRepositorio.saveAll(Arrays.asList(e1 ,e2));
 * 
 * SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
 * 
 * Pedido ped1 = new Pedido(null, sdf.parse("30/12/2017 10:32") , cli1 , e1 );
 * Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35") , cli1 , e2 );
 * 
 * Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO ,
 * ped1 , 6); ped1.setPagamento(pagto1); Pagamento pagto2 = new
 * PagamentoComBoleto( null , EstadoPagamento.PENDENTE , ped2
 * ,sdf.parse("20/10/2017 00:00") , null ); ped2.setPagamento(pagto2);
 * cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
 * 
 * pedidoRepositorio.saveAll(Arrays.asList(ped1 , ped2));
 * pagamentoRepositorio.saveAll(Arrays.asList(pagto1 , pagto2));
 * 
 * 
 * ItemPedido ip1 = new ItemPedido(ped1 , p1 , 0.00 , 1 , 2000.00); ItemPedido
 * ip2 = new ItemPedido(ped1 , p3 , 0.00 , 2 , 80.00); ItemPedido ip3 = new
 * ItemPedido(ped2 , p2 , 100.00 , 1 , 800.00);
 * 
 * ped1.getItens().addAll(Arrays.asList(ip1 , ip2));
 * ped2.getItens().addAll(Arrays.asList(ip3));
 * 
 * p1.getItens().addAll(Arrays.asList(ip1));
 * p2.getItens().addAll(Arrays.asList(ip3));
 * p3.getItens().addAll(Arrays.asList(ip2));
 * 
 * itemPedidoRepositorio.saveAll(Arrays.asList(ip1, ip2 , ip3));
 * 
 * 
 * }
 */
// }
