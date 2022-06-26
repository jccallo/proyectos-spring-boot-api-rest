package pe.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.idat.entity.Producto;
import pe.idat.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService
{
	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	@Transactional
	public void insert(Producto producto) {
		productoRepository.save(producto);
	}

	@Override
	@Transactional
	public void update(Producto producto) {
		productoRepository.save(producto);
	}

	@Override
	@Transactional
	public void delete(Integer productoId) {
		productoRepository.deleteById(productoId);
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Integer productoId) {
		return productoRepository.findById(productoId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Producto> findAll() {
		return productoRepository.findAll();
	}
	
	
	//BD virtual
//	private static Map<Integer,Producto> tblProductos=new HashMap<>();
//	static
//	{
//		Producto p1=new Producto(1,"Bombones","Costa",15.20);
//		Producto p2=new Producto(2,"Chocolates","Bimbo",14.50);
//		Producto p3=new Producto(3,"Flores","Rosatel",30.90);
//		Producto p4=new Producto(4,"Champagne","Rose",25.40);
//		
//		tblProductos.put(p1.getProductoId(),p1);
//		tblProductos.put(p2.getProductoId(),p2);
//		tblProductos.put(p3.getProductoId(),p3);
//		tblProductos.put(p4.getProductoId(),p4);
//	}
//
//	@Override
//	public void insert(Producto producto) 
//	{
//		producto.setProductoId(tblProductos.size()+1);
//		tblProductos.put(producto.getProductoId(),producto);
//	}
//
//	@Override
//	public void update(Producto producto) {
//		tblProductos.put(producto.getProductoId(),producto);		
//	}
//
//	@Override
//	public void delete(Integer productoId) {
//		tblProductos.remove(productoId);		
//	}
//
//	@Override
//	public Producto findById(Integer productoId) {
//		return tblProductos.get(productoId);
//	}
//
//	@Override
//	public Collection<Producto> findAll() {
//		return tblProductos.values();
//	}
}
