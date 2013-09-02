package br.com.uni.web.controle.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.uni.modelo.Bookmark;
import br.com.uni.modelo.persistencia.BookmarkDAO;

@RequestScoped
@ManagedBean
public class BookmarkControler {

	// campos do formularios
	private Bookmark bookmark = new Bookmark();

	private DataModel<Bookmark> bookmarks = new ListDataModel<Bookmark>();

	private BookmarkDAO dao = new BookmarkDAO();

	// açoes da página
	public String salvar() {
		dao.salvar(bookmark);
		bookmark = new Bookmark();
		return "list";
	}

	public String mostraFormEditar() {
		bookmark = bookmarks.getRowData();
		return "edit";
	}

	public String gravaEdicao() {
		dao.editar(bookmark);
		bookmark = new Bookmark();
		return "list";
	}

	public String excluir() {
		bookmark = bookmarks.getRowData();
		dao.excluir(bookmark.getId());
		bookmark = new Bookmark();
		return "list";
	}

	// gets e sets. afinal isso é um bean!
	public Bookmark getBookmark() {
		return bookmark;
	}

	public void setBookmark(Bookmark bookmark) {
		this.bookmark = bookmark;
	}

	public DataModel<Bookmark> getBookmarks() {
		bookmarks = new ListDataModel<Bookmark>(dao.listar());
		return bookmarks;
	}

	public void setBookmarks(DataModel<Bookmark> bookmarks) {
		this.bookmarks = bookmarks;
	}

}
