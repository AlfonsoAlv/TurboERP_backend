package com.turbomaquinas.POJO.comercial;

public class ClienteVista {
	private int id;
	private int numero;
	private String nombre_fiscal;
    private String direccion_fiscal;
    private String colonia_fiscal;
    private String codigo_postal_fiscal;
    private String rfc;
    private int dias_credito;
    private String nombre_comercial;
    private String direccion_planta;
    private String colonia_planta;
    private int activo;
    private int ciudades_id;
	private String ciudad;
	private int estados_id;
	private String estado;
	private int pais_id;
	private String pais;
	private int giros_id;
	private int num_giro;
	private String des_giro;
	private int personal_id;
	private String personal;
	private int ciudad_comercial_id;
	private String ciudad_c;
	private int estado_c_id;
	private String estado_c;
	private int cve_formaP;
	private String nom_formaP;
	private String cve_metodoP;
	private String nom_metodoP;
	private String cve_usocfdi;
	private String nom_usocfdi;
	private int metodos_pago_id;
	private int formas_pago_id;
	private int uso_cfdi_id;
	private String comisionista;

	public ClienteVista() {
		super();
	}

	public ClienteVista(int id, int numero, String nombre_fiscal, String direccion_fiscal, String colonia_fiscal,
			String codigo_postal_fiscal, String rfc, int dias_credito, String nombre_comercial, String direccion_planta,
			String colonia_planta, int activo, int ciudades_id, String ciudad, int estados_id, String estado,
			int pais_id, String pais, int giros_id, int num_giro, String des_giro, int personal_id, String personal,
			int ciudad_comercial_id, String ciudad_c, int estado_c_id, String estado_c, int cve_formaP,
			String nom_formaP, String cve_metodoP, String nom_metodoP, String cve_usocfdi, String nom_usocfdi,
			int metodos_pago_id, int formas_pago_id, int uso_cfdi_id, String comisionista) {
		super();
		this.id = id;
		this.numero = numero;
		this.nombre_fiscal = nombre_fiscal;
		this.direccion_fiscal = direccion_fiscal;
		this.colonia_fiscal = colonia_fiscal;
		this.codigo_postal_fiscal = codigo_postal_fiscal;
		this.rfc = rfc;
		this.dias_credito = dias_credito;
		this.nombre_comercial = nombre_comercial;
		this.direccion_planta = direccion_planta;
		this.colonia_planta = colonia_planta;
		this.activo = activo;
		this.ciudades_id = ciudades_id;
		this.ciudad = ciudad;
		this.estados_id = estados_id;
		this.estado = estado;
		this.pais_id = pais_id;
		this.pais = pais;
		this.giros_id = giros_id;
		this.num_giro = num_giro;
		this.des_giro = des_giro;
		this.personal_id = personal_id;
		this.personal = personal;
		this.ciudad_comercial_id = ciudad_comercial_id;
		this.ciudad_c = ciudad_c;
		this.estado_c_id = estado_c_id;
		this.estado_c = estado_c;
		this.cve_formaP = cve_formaP;
		this.nom_formaP = nom_formaP;
		this.cve_metodoP = cve_metodoP;
		this.nom_metodoP = nom_metodoP;
		this.cve_usocfdi = cve_usocfdi;
		this.nom_usocfdi = nom_usocfdi;
		this.metodos_pago_id = metodos_pago_id;
		this.formas_pago_id = formas_pago_id;
		this.uso_cfdi_id = uso_cfdi_id;
		this.comisionista = comisionista;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre_fiscal() {
		return nombre_fiscal;
	}

	public void setNombre_fiscal(String nombre_fiscal) {
		this.nombre_fiscal = nombre_fiscal;
	}

	public String getDireccion_fiscal() {
		return direccion_fiscal;
	}

	public void setDireccion_fiscal(String direccion_fiscal) {
		this.direccion_fiscal = direccion_fiscal;
	}

	public String getColonia_fiscal() {
		return colonia_fiscal;
	}

	public void setColonia_fiscal(String colonia_fiscal) {
		this.colonia_fiscal = colonia_fiscal;
	}

	public String getCodigo_postal_fiscal() {
		return codigo_postal_fiscal;
	}

	public void setCodigo_postal_fiscal(String codigo_postal_fiscal) {
		this.codigo_postal_fiscal = codigo_postal_fiscal;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public int getDias_credito() {
		return dias_credito;
	}

	public void setDias_credito(int dias_credito) {
		this.dias_credito = dias_credito;
	}

	public String getNombre_comercial() {
		return nombre_comercial;
	}

	public void setNombre_comercial(String nombre_comercial) {
		this.nombre_comercial = nombre_comercial;
	}

	public String getDireccion_planta() {
		return direccion_planta;
	}

	public void setDireccion_planta(String direccion_planta) {
		this.direccion_planta = direccion_planta;
	}

	public String getColonia_planta() {
		return colonia_planta;
	}

	public void setColonia_planta(String colonia_planta) {
		this.colonia_planta = colonia_planta;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public int getCiudades_id() {
		return ciudades_id;
	}

	public void setCiudades_id(int ciudades_id) {
		this.ciudades_id = ciudades_id;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getEstados_id() {
		return estados_id;
	}

	public void setEstados_id(int estados_id) {
		this.estados_id = estados_id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getPais_id() {
		return pais_id;
	}

	public void setPais_id(int pais_id) {
		this.pais_id = pais_id;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getGiros_id() {
		return giros_id;
	}

	public void setGiros_id(int giros_id) {
		this.giros_id = giros_id;
	}

	public int getNum_giro() {
		return num_giro;
	}

	public void setNum_giro(int num_giro) {
		this.num_giro = num_giro;
	}

	public String getDes_giro() {
		return des_giro;
	}

	public void setDes_giro(String des_giro) {
		this.des_giro = des_giro;
	}

	public int getPersonal_id() {
		return personal_id;
	}

	public void setPersonal_id(int personal_id) {
		this.personal_id = personal_id;
	}

	public String getPersonal() {
		return personal;
	}

	public void setPersonal(String personal) {
		this.personal = personal;
	}

	public int getCiudad_comercial_id() {
		return ciudad_comercial_id;
	}

	public void setCiudad_comercial_id(int ciudad_comercial_id) {
		this.ciudad_comercial_id = ciudad_comercial_id;
	}

	public String getCiudad_c() {
		return ciudad_c;
	}

	public void setCiudad_c(String ciudad_c) {
		this.ciudad_c = ciudad_c;
	}

	public int getEstado_c_id() {
		return estado_c_id;
	}

	public void setEstado_c_id(int estado_c_id) {
		this.estado_c_id = estado_c_id;
	}

	public String getEstado_c() {
		return estado_c;
	}

	public void setEstado_c(String estado_c) {
		this.estado_c = estado_c;
	}

	public int getCve_formaP() {
		return cve_formaP;
	}

	public void setCve_formaP(int cve_formaP) {
		this.cve_formaP = cve_formaP;
	}

	public String getNom_formaP() {
		return nom_formaP;
	}

	public void setNom_formaP(String nom_formaP) {
		this.nom_formaP = nom_formaP;
	}

	public String getCve_metodoP() {
		return cve_metodoP;
	}

	public void setCve_metodoP(String cve_metodoP) {
		this.cve_metodoP = cve_metodoP;
	}

	public String getNom_metodoP() {
		return nom_metodoP;
	}

	public void setNom_metodoP(String nom_metodoP) {
		this.nom_metodoP = nom_metodoP;
	}

	public String getCve_usocfdi() {
		return cve_usocfdi;
	}

	public void setCve_usocfdi(String cve_usocfdi) {
		this.cve_usocfdi = cve_usocfdi;
	}

	public String getNom_usocfdi() {
		return nom_usocfdi;
	}

	public void setNom_usocfdi(String nom_usocfdi) {
		this.nom_usocfdi = nom_usocfdi;
	}

	public int getMetodos_pago_id() {
		return metodos_pago_id;
	}

	public void setMetodos_pago_id(int metodos_pago_id) {
		this.metodos_pago_id = metodos_pago_id;
	}

	public int getFormas_pago_id() {
		return formas_pago_id;
	}

	public void setFormas_pago_id(int formas_pago_id) {
		this.formas_pago_id = formas_pago_id;
	}

	public int getUso_cfdi_id() {
		return uso_cfdi_id;
	}

	public void setUso_cfdi_id(int uso_cfdi_id) {
		this.uso_cfdi_id = uso_cfdi_id;
	}

	public String getComisionista() {
		return comisionista;
	}

	public void setComisionista(String comisionista) {
		this.comisionista = comisionista;
	}

	@Override
	public String toString() {
		return "ClienteVista [id=" + id + ", numero=" + numero + ", nombre_fiscal=" + nombre_fiscal
				+ ", direccion_fiscal=" + direccion_fiscal + ", colonia_fiscal=" + colonia_fiscal
				+ ", codigo_postal_fiscal=" + codigo_postal_fiscal + ", rfc=" + rfc + ", dias_credito=" + dias_credito
				+ ", nombre_comercial=" + nombre_comercial + ", direccion_planta=" + direccion_planta
				+ ", colonia_planta=" + colonia_planta + ", activo=" + activo + ", ciudades_id=" + ciudades_id
				+ ", ciudad=" + ciudad + ", estados_id=" + estados_id + ", estado=" + estado + ", pais_id=" + pais_id
				+ ", pais=" + pais + ", giros_id=" + giros_id + ", num_giro=" + num_giro + ", des_giro=" + des_giro
				+ ", personal_id=" + personal_id + ", personal=" + personal + ", ciudad_comercial_id="
				+ ciudad_comercial_id + ", ciudad_c=" + ciudad_c + ", estado_c_id=" + estado_c_id + ", estado_c="
				+ estado_c + ", cve_formaP=" + cve_formaP + ", nom_formaP=" + nom_formaP + ", cve_metodoP="
				+ cve_metodoP + ", nom_metodoP=" + nom_metodoP + ", cve_usocfdi=" + cve_usocfdi + ", nom_usocfdi="
				+ nom_usocfdi + ", metodos_pago_id=" + metodos_pago_id + ", formas_pago_id=" + formas_pago_id
				+ ", uso_cfdi_id=" + uso_cfdi_id + ", comisionista=" + comisionista + "]";
	}
}
