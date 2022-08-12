package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import model.Proprietario;
import model.Veiculo;

public class VeiculoDao {

	public static int deletarVeiculo(Veiculo v) {
		int status = 0;
		
		try {
			
			Connection con = Conexao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from veiculo where id=?");
			ps.setInt(1, v.getId());
			status = ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	//--------------------------------------------------------------------------
	
	public static int salvarVeiculo(Veiculo v) {
		int status = 0;
		
		try {
			Connection con = Conexao.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into veiculo (placa,renavam,id_prop) values (?,?,?)");
			ps.setString(1, v.getPlaca());
			ps.setString(2, v.getRenavam());
			ps.setInt(3, v.getProprietario().getId());
			status = ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
		
	}
	//----------------------------------------------------------------------------------------------------
	
	public static Veiculo getRegistroById(int id) {
		Veiculo veiculo = null;
		
		try {
			Connection con = Conexao.getConnection();
			PreparedStatement ps = con.prepareStatement("select v.id as vid, placa, renavam, id_prop, p.id as pid,nome from veiculo v join proprietario p on v.id_prop=p.id where v.id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				veiculo = new Veiculo();
				veiculo.setId(rs.getInt("vid"));
				veiculo.setPlaca(rs.getString("placa"));
				veiculo.setRenavam(rs.getString("renavam"));
				
				Proprietario p = new Proprietario();
				p.setId(rs.getInt("id_prop"));
				p.setNome(rs.getString("nome"));
				veiculo.setProprietario(p);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return veiculo;
	}
	//---------------------------------------------------------------------
	
	public static int updateVeiculo(Veiculo v) {
		int status = 0;
		
		try {
			Connection con = Conexao.getConnection();
			PreparedStatement ps = con.prepareStatement("update veiculo set placa=?, renavam=?, id_prop=? where id=?");
			
			ps.setString(1, v.getPlaca());
			ps.setString(2, v.getRenavam());
			ps.setInt(3, v.getProprietario().getId());
			ps.setInt(4, v.getId());
			status = ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}


//--------------------------------------------------------------------
	
	public static List<Veiculo> getAllVeiculos(){
		List<Veiculo> list = new ArrayList<Veiculo>();
		
		try {
			Connection con = Conexao.getConnection();
			PreparedStatement ps = con.prepareStatement("select v.id as vid,placa,renavam,p.id as pid,p.cpf_cnpj as pcpf_cnpj,p.nome as pnome from veiculo v join proprietario p on v.id_prop =p.id order by v.id ");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Veiculo veiculo = new Veiculo();
				veiculo.setId(rs.getInt("vid"));
				veiculo.setPlaca(rs.getString("placa"));
				veiculo.setRenavam(rs.getString("renavam"));
				
				Proprietario proprietario = new Proprietario();
				proprietario.setId(rs.getInt("pid"));
				proprietario.setCpf_cnpj(rs.getString("pcpf_cnpj"));
				proprietario.setNome(rs.getString("pnome"));
				veiculo.setProprietario(proprietario);
				
				
				list.add(veiculo);
			}	
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
//---------------------------------------------------------------------
	
}
