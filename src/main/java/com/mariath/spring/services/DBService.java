package com.mariath.spring.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mariath.spring.domain.Cidade;
import com.mariath.spring.domain.Cliente;
import com.mariath.spring.domain.Endereco;
import com.mariath.spring.domain.Estado;
import com.mariath.spring.domain.enums.TipoCliente;
import com.mariath.spring.domain.enums.Perfil;
import com.mariath.spring.repositories.CidadeRepository;
import com.mariath.spring.repositories.ClienteRepository;
import com.mariath.spring.repositories.EnderecoRepository;
import com.mariath.spring.repositories.EstadoRepository;

@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder be;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepositoty;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	public void instantiateDataBase() {

		Estado est1 = new Estado(null, "Rio Grande do Sul");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Porto Alegre", est1);
		Cidade c2 = new Cidade(null, "Canoas", est1);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1, c2));
		est2.getCidades().addAll(Arrays.asList(c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepositoty.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Maria da Silva", "11/01/1943", "maria@gmail.com", "36378912377",
				TipoCliente.PESSOAFISICA, be.encode("123"));
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Cliente cli2 = new Cliente(null, "Joao Raimundo Alves", "20/08/1980", "admin@bempromo.com", "15348733091", 
				TipoCliente.PESSOAFISICA, be.encode("123"));
		cli2.addPerfil(Perfil.ADMIN);
		cli2.getTelefones().addAll(Arrays.asList("34567812", "99342517"));

		Endereco e1 = new Endereco(null, "Rua FLores", "300", "Apto 203", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Apto 612", "Costa e Silva", "3877012", cli1, c2);
		Endereco e3 = new Endereco(null, "Rua da Redenção", "3176", "Apto 400", "Centro", "924124333", cli2, c3);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli2.getEnderecos().addAll(Arrays.asList(e3));

		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));

	}

}
