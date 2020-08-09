package fr.maxlego08.shop.inventory;

import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.entity.Player;

import fr.maxlego08.shop.api.button.Button;
import fr.maxlego08.shop.api.inventory.Inventory;

public class InventoryObject implements Inventory {

	private final String name;
	private final int size;
	private final List<Button> buttons;

	/**
	 * @param name
	 * @param size
	 * @param button
	 */
	public InventoryObject(String name, int size, List<Button> buttons) {
		super();
		this.name = name;
		this.size = size;
		this.buttons = buttons;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getName(String replace, String newChar) {
		return name.replace(replace, newChar);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Button> List<T> getButtons(Class<T> type) {
		return buttons.stream().filter(e -> e.getClass().isAssignableFrom(type.getClass())).map(e -> (T) e)
				.collect(Collectors.toList());
	}

	@Override
	public List<Button> getButtons() {
		return buttons;
	}

	@Override
	public void open(Player player) {
		// TODO Auto-generated method stub

	}

}
