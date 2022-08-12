package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Proprietario;
import conexao.Conexao;

public class ProprietarioDao {
	
	//aqui iremos deletar o proprietario escolhido
	
		public static int deletarProprietario(Proprietario p) {
			int status = 0;
			
			try {
				
				Connection con = Conexao.getConnection();
				PreparedStatement ps = con.prepareStatement("delete from proprietario where id=?");
				ps.setInt(1, p.getId());
				status = ps.executeUpdate();
				
			} catch (Exception e) {
				System.out.println(e);
			}
			return status;
		}
		
		//--------------------------------------------------
		
		
		// aqui eu irei adicionar o proprietario
		
		public static int salvarProprietario(Proprietario p) {
			int status = 0;
			
			try {
				Connection con = Conexao.getConnection();
				PreparedStatement ps = con.prepareStatement("insert into proprietario (cpf_cnpj,nome,endereco) values (?,?,?)");
				ps.setString(1, p.getCpf_cnpj());
				ps.setString(2, p.getNome());
				ps.setString(3, p.getEndereco());
				status = ps.executeUpdate();
			}catch (Exception e) {
				System.out.println(e);
			}
			
			return status;
			
			
		}
		
		//------------------------------------------------------------------
		
		//aqui eu consigo pegar o id do meu proprietario para visualizar ele no form.
		
		public static Proprietario getRegistroById(int id) {
			Proprietario proprietario = null;
			
			try {
				Connection con = Conexao.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from proprietario where id=?");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					proprietario = new Proprietario();
					proprietario.setId(rs.getInt("id"));
					proprietario.setCpf_cnpj(rs.getString("cpf_cnpj"));
					proprietario.setNome(rs.getString("nome"));
					proprietario.setEndereco(rs.getString("endereco"));
				}
			}catch (Exception e) {
				System.out.println(e);
			}
			return proprietario;
		}
		//---------------------------------------------------------------------
		
		//aqui eu consigo mandar um comando de edição update
		
			public static int updateProprietario(Proprietario p) {
				int status = 0;
				
				try {
					Connection con = Conexao.getConnection();
					PreparedStatement ps = con.prepareStatement("update proprietario set cpf_cnpj=?, nome=?, endereco=? where id=?");
					
					ps.setString(1, p.getCpf_cnpj());
					ps.setString(2, p.getNome());
					ps.setString(3, p.getEndereco());
					ps.setInt(4, p.getId());
					status = ps.executeUpdate();
				}catch (Exception e) {
					System.out.println(e);
				}
				return status;
			}

		
		//--------------------------------------------------------------------
		
		//Aqui ele esta criando um metodo para mostrar todos os proprietarios
		public static List<Proprietario> getAllProprietarios(){
			List<Proprietario> list = new ArrayList<Proprietario>();
			
			try {
				Connection con = Conexao.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from proprietario order by id");
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					Proprietario proprietario = new Proprietario();
					proprietario.setId(rs.getInt("id"));
					proprietario.setCpf_cnpj(rs.getString("cpf_cnpj"));
					proprietario.setNome(rs.getString("nome"));
					proprietario.setEndereco(rs.getString("endereco"));
					list.add(proprietario);
				}	
			} catch (Exception e) {
				System.out.println(e);
			}
			return list;
		}
	//---------------------------------------------------------------------

}
