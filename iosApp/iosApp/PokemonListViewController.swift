//
//  PokemonListViewController.swift
//  iosApp
//
//  Created by Kevin Salazar on 9/16/20.
//  Copyright © 2020 orgName. All rights reserved.
//

import UIKit
import shared

class PokemonListViewController: UIViewController {

    let viewModel = Provider.init().providePokemonListViewModel()
    
    @IBOutlet weak var name: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        observeViewModel()
        
        viewModel.getPokemonList()
        
    }

    func observeViewModel() {
        viewModel.viewState.addObserver { (state) in
            if (state is PokemonListViewState.Success) {
                self.name.text = "SUCCESS"
            } else if (state is PokemonListViewState.Loading) {
                self.name.text = "Loading"
            } else if (state is PokemonListViewState.Error) {
                self.name.text = "ERROR"
            }
            
        }
    }
    
}
