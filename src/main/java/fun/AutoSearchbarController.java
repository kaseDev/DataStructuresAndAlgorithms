package fun;

import datastructs.MyTrie;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AutoSearchbarController {

	@FXML private TextField searchBar;
	@FXML private ListView<String> searchResults;

	private MyTrie trie = new MyTrie();

	@FXML
	public void addWord() {
		trie.insertWord(searchBar.getText());

		for (String string : trie.getPossibleWords()) {
			System.out.println(string);
		}
		System.out.println("-- done --");
	}
}
