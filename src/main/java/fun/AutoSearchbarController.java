package fun;

import datastructs.MyTrie;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class AutoSearchbarController {

	@FXML private TextField searchBar;
	@FXML private ListView<String> searchRecommendations;

	private MyTrie trie = new MyTrie();

	@FXML
	public void addWord() {
		trie.insertWord(searchBar.getText());
		System.out.println(searchBar.getText());
	}

	@FXML
	public void updateRecommendations(KeyEvent event) {
		searchRecommendations.getItems().clear();
		if (searchBar.getText().equals(""))
			return;
		if (trie.goToString(searchBar.getText()))
			searchRecommendations.getItems().addAll(trie.getPossibleWords(10));
	}
}
